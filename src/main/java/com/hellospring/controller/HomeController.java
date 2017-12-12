package com.hellospring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.hellospring.Dao.ProductDao;
import com.hellospring.model.Product;

@Controller
public class HomeController {
//	List<Product>productList;
	
    private Path path ;
    
	@Autowired
    private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/productList")
    public String productList(Model model){
		
//		this.productList = productDao.getProductList();
		List<Product>products = productDao.getAllProducts();
		model.addAttribute("products",products);
		return "productList";
	}
	
	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId,Model model) throws IOException{
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "viewProduct";
	} 
	
	@RequestMapping("/admin")
	public String adminPage(){
		return "admin";
	}
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model){
		List<Product>products= this.productDao.getAllProducts();
		model.addAttribute("products",products);
		return "productInventory";
	}
	@RequestMapping("/admin/productInventory/addProduct")
	public String addproduct(Model model){
		Product product = new Product();
		product.setProductCategory("Instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		product.setUnitInStock(3);
		
		model.addAttribute("product",product);
       return "addProduct";
	}
	
	@RequestMapping(value="/admin/productInventory/addProduct",method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product")Product product, HttpServletRequest request){
		this.productDao.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		this.path = Paths.get(rootDirectory +"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable String id,Model model) {
		this.productDao.deleteProduct(id);
		return "redirect:/admin/productInventory";
	} 
	
		
	
}
