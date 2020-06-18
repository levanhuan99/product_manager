package com.huan.controller;


import com.huan.model.Product;
import com.huan.service.IProductService;
import com.huan.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    IProductService iProductService=ProductService.getProductService();

    @GetMapping("/")
    public String index(Model model){
        List<Product> list= iProductService.getAllProduct();
        model.addAttribute("products",list);
        return "index";
    }

    @GetMapping("/product/edit/{id}")
    public String getEditForm(@PathVariable int id,Model model){
        Product product=iProductService.getProductById(id);
        model.addAttribute("product",product);
        return "edit_form";
    }
    @PostMapping ("/product/update")
    public String update(Product product, RedirectAttributes redirectAttributes){  //product đã khởi tạo chưa?
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("success", "edit successful");
        return "redirect:/";

    }

    @GetMapping("/product/add")
    public String add(Model model){
        model.addAttribute("product",new Product());
        return "add_form";
    }
    @PostMapping("/product/save")
    public String save(Product product,RedirectAttributes redirectAttributes){
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success", "edit successful");
        return "redirect:/";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.getProductById(id));
        return "delete_form";

    }
    @PostMapping("/product/save_chage")
    public String delete(Product product,RedirectAttributes redirectAttributes){
        iProductService.remove( product.getId());
        redirectAttributes.addFlashAttribute("success", "delete successful");
        return "redirect:/";
    }
    @GetMapping("/product/view/{id}")
    public String viewDetail(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.getProductById(id));
        return "view_detail";

    }


}
