/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.entity.Job;
import com.lssrc.cms.entity.User;
import com.lssrc.cms.service.JobService;
import com.lssrc.util.DateFormater;
import com.lssrc.util.ErrorCode;
import com.lssrc.util.Navigator;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/zhaopin")
public class JobAdminController {
	
	private User myself;

	@Autowired
	private JobService jobService;
	
	@RequestMapping(value = { "/", "" })
	public String list(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Navigator navigator = jobService.getNavigator(pageNo, pageSize, null);

		model.addAttribute("navigator", navigator);
		model.addAttribute("jobs", jobService.getByPage(navigator, null));

		return Constants.ADMIN_PATH_NAME + "/job/list";
	}
	
	@RequestMapping(value = { "/add" })
	public String add(Model model) {
		model.addAttribute("belongs", jobService.getBelong());
		return Constants.ADMIN_PATH_NAME + "/job/add";
	}

	@RequestMapping(value = { "/save" })
	public String save(
			ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "organizer", required = true) String organizer,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "place", required = true) String place,
			@RequestParam(value = "salary", required = false, defaultValue = "0") String salary,
			@RequestParam(value = "datetime-work", required = false, defaultValue = "") String datetimeWork,
			@RequestParam(value = "number", required = false, defaultValue = "0") Integer number,
			@RequestParam(value = "number-limit", required = false, defaultValue = "0") Integer numberLimit,
			@RequestParam(value = "contact", required = false, defaultValue = "") String contact,
			@RequestParam(value = "datetime-start", required = false, defaultValue = "") String datetimeStart,
			@RequestParam(value = "datetime-end", required = false, defaultValue = "") String datetimeEnd,
			@RequestParam(value = "audition-place", required = false, defaultValue = "") String auditionPlace,
			@RequestParam(value = "content", required = false, defaultValue = "") String content,
			@RequestParam(value = "belong", required = true) String belong) {

		String userId = myself.getUserId();
		Job job = new Job();
		if (StringUtils.isEmpty(id)) {
			job.setjId(UUID.generateRandomUUID());
		} else {
			job = jobService.getById(id).getJob();
		}
		
		job.setjTitle(title);
		job.setjOrganizer(organizer);
		job.setjType(type);
		job.setjWorkPlace(place);
		job.setjSalary(salary);
		job.setjWorkTime(datetimeWork);
		job.setjNumber(number);
		job.setjNumberLimit(numberLimit);
		job.setjAuditionPlace(auditionPlace);
		job.setjAuditionTime(datetimeStart);
		job.setjDatetimeEnd(datetimeEnd);
		job.setjContact(contact);
		job.setjContent(content);
		job.setjBelong(belong);
		
		if (StringUtils.isEmpty(id)) {
			job.setjDatetimeBuild(DateFormater.getDateTime());
			job.setjBuilder(myself.getUserAccount());
			int count = jobService.save(job);
		} else {
			int count = jobService.update(job);
		}
		return "redirect:/admin/zhaopin";
	}
	
	@RequestMapping(value = { "/edit/{id}" })
	public String edit(ModelMap model,
			@PathVariable("id")String id) {
		Job job = jobService.getById(id).getJob();
		if(job != null) {
			model.addAttribute("job", job);
			model.addAttribute("belongs", jobService.getBelong());
			model.addAttribute("types", jobService.getType());
			return Constants.ADMIN_PATH_NAME + "/job/edit";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}
	
	@RequestMapping(value = { "/delete/{id}" })
	public String delete(@PathVariable("id")String id) {
		int count = jobService.delete(id);
		return "redirect:/admin/zhaopin";
	}
	
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (User) session.getAttribute("myself");
	}
	
}
