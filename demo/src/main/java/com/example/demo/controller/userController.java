package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.user;
import com.example.demo.repository.userRepository;

@Controller
@RequestMapping("user")
public class userController {
  @Autowired

  private userRepository userRepository;

  /**
   * Description: 文章列表
   */
  @RequestMapping("")
  public ModelAndView userlist(@RequestParam(value = "start", defaultValue = "0") Integer start,
      @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
    start = start < 0 ? 0 : start;
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    PageRequest pageable = PageRequest.of(start, limit, sort);
    Page<user> page = userRepository.findAll(pageable);
    ModelAndView mav = new ModelAndView("user/list");
    mav.addObject("page", page);
    return mav;
  }

  /**
   * Description: 新增操作视图
   */
  @GetMapping("/add")
  public String adduser() throws Exception {
    return "user/add";
  }

  /**
   * Description: 新增保存方法
   */
  @PostMapping("")
  public String saveuser(user model) throws Exception {
    userRepository.save(model);
    return "redirect:/user/";
  }

  /**
   * Description: 编辑视图
   */
  @GetMapping("/edit/{id}")
  public ModelAndView edituser(@PathVariable("id") long id) throws Exception {
    user model = userRepository.findById(id);
    ModelAndView mav = new ModelAndView("user/edit");
    mav.addObject("user", model);
    return mav;
  }

  /**
   * Description: 修改方法
   */
  @PutMapping("/{id}")
  public String edituserSave(user model, long id) throws Exception {
    model.setId(id);
    userRepository.save(model);
    return "redirect:";
  }

}
