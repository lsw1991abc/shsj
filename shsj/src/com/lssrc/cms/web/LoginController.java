/**
 * LoginController.java
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月5日
 */
package com.lssrc.cms.web;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lssrc.cms.service.UserService;
import com.lssrc.util.MD5;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/login")
@SessionAttributes(types = {HashMap.class}, value = {"myself"})
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * 默认
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "")
	public String index() {
		return "login";
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "username", required = false, defaultValue = "") String username,
			@RequestParam(value = "password", required = false, defaultValue = "") String password,
			@RequestParam(value = "verifyCode", required = false, defaultValue = "") String verifyCode) {
		if (StringUtils.isEmpty(verifyCode) || !verifyCode.equalsIgnoreCase(request.getSession(true).getAttribute("randCheckCode").toString())) {
			model.addAttribute("msg", "error1");
			return "login";
		}
		
		HashMap<String, Object> user = (HashMap<String, Object>) userService.getByUsername(username);
		if (user != null && user.get("passwd").toString().equals(MD5.getMD5Code(password))) {
				model.addAttribute("myself", user);
				return "redirect:/user/";
		} else {
			model.addAttribute("msg", "error2");
			return "login";
		}
	}
	
	/**
	 * 注册页面跳转
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "register")
	public String register() {
		return "register";
	}
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "reg")
	public String reg(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "username", required = true)String username,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "password2", required = true)String password2,
			@RequestParam(value = "qq", required = false, defaultValue = "")String qq,
			@RequestParam(value = "phoneno", required = false, defaultValue = "")String phoneno,
			@RequestParam(value = "email", required = false, defaultValue = "")String email,
			@RequestParam(value = "verifyCode", required = false, defaultValue = "") String verifyCode) {
		username = StringUtils.trim(username);
		password = StringUtils.trim(password);
		password2 = StringUtils.trim(password2);
		qq = StringUtils.trim(qq);
		phoneno = StringUtils.trim(phoneno);
		email = StringUtils.trim(email);
		
		model.addAttribute("username", username);
		model.addAttribute("qq", qq);
		model.addAttribute("phoneno", phoneno);
		model.addAttribute("email", email);
		
		if (StringUtils.isEmpty(verifyCode) || !verifyCode.equalsIgnoreCase(request.getSession(true).getAttribute("randCheckCode").toString())) {
			model.addAttribute("msg", "error1");
			return "register";
		}
		if (!userService.isNotExist(username)) {
			model.addAttribute("msg", "error2");
			return "register";
		}
		
		if (StringUtils.isNotEmpty(username) && 
				StringUtils.isNotEmpty(password) &&
				StringUtils.equals(password, password2)) {
				Map<String, String> contations = new HashMap<String, String>();
				contations.put("username", username);
				contations.put("password", MD5.getMD5Code(password));
				contations.put("qq", qq);
				contations.put("phoneno", phoneno);
				contations.put("email", email);
				if (userService.save(contations)) {
					model.addAttribute("msg", "success");
				} else {
					model.addAttribute("msg", "error");
				}
		} else {
			model.addAttribute("msg", "error");
		}
		return "register";
	}
	
	/**
	 * 验证码
	 * @param request
	 * @param response
	 * @param model
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = {"/verifyCode"})
	public void VerifyCode(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        // 指定生成的响应是图片
        response.setContentType("image/jpeg");
        int width = 200;
        int height = 60;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 创建BufferedImage类的对象
        Graphics g = image.getGraphics(); // 创建Graphics类的对象
        Graphics2D g2d = (Graphics2D) g; // 通过Graphics类的对象创建一个Graphics2D类的对象
        Random random = new Random(); // 实例化一个Random对象
        Font mFont = new Font("华文宋体", Font.BOLD, 30); // 通过Font构造字体
        g.setColor(getRandColor(200, 250)); // 改变图形的当前颜色为随机生成的颜色
        g.fillRect(0, 0, width, height); // 绘制一个填色矩形

        // 画一条折线
        BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT,  BasicStroke.JOIN_BEVEL); // 创建一个供画笔选择线条粗细的对象
        g2d.setStroke(bs); // 改变线条的粗细
        g.setColor(Color.DARK_GRAY); // 设置当前颜色为预定义颜色中的深灰色
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        for (int j = 0; j < 3; j++) {
            xPoints[j] = random.nextInt(width - 1);
            yPoints[j] = random.nextInt(height - 1);
        }
        g.drawPolyline(xPoints, yPoints, 3);
        // 生成并输出随机的验证文字
        g.setFont(mFont);
        String sRand = "";
        int itmp = 0;
        for (int i = 0; i < 4; i++) {
            if (random.nextInt(2) == 1) {
                itmp = random.nextInt(26) + 65; // 生成A~Z的字母
            } else {
                itmp = random.nextInt(10) + 48; // 生成0~9的数字
            }
            char ctmp = (char) itmp;
            sRand += String.valueOf(ctmp);
            Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110));
            g.setColor(color);
            /**** 随机缩放文字并将文字旋转指定角度 **/
            // 将文字旋转指定角度
            Graphics2D g2d_word = (Graphics2D) g;
            AffineTransform trans = new AffineTransform();
            trans.rotate(random.nextInt(45) * 3.14 / 180, 15 * i + 10, 7);
            // 缩放文字
            float scaleSize = random.nextFloat() + 0.8f;
            if (scaleSize > 1.1f)
                scaleSize = 1f;
            trans.scale(scaleSize, scaleSize);
            g2d_word.setTransform(trans);
            /************************/
            g.drawString(String.valueOf(ctmp), 30 * i + 40, 16);

        }
        // 将生成的验证码保存到Session中
        HttpSession session = request.getSession(true);
        session.setAttribute("randCheckCode", sRand);
        g.dispose();
        try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
	
    public Color getRandColor(int s, int e) {
        Random random = new Random();
        if (s > 255)
            s = 255;
        if (e > 255)
            e = 255;
        int r = s + random.nextInt(e - s);
        int g = s + random.nextInt(e - s);
        int b = s + random.nextInt(e - s);
        return new Color(r, g, b);
    }

	
}
