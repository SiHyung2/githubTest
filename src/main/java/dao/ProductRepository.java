package dao;

import java.util.ArrayList;
import dto.Product;

public class ProductRepository {
   private ArrayList<Product> listOfProducts= new ArrayList<Product>();
   
//	--6장 사용 코드--
   private static ProductRepository instance=new ProductRepository();
   public static ProductRepository getInstance() {
	   return instance;
   }
   public void addProduct(Product product) {
	   listOfProducts.add(product);
   }
//   --ㅇ--
    public ArrayList<Product> getAllProducts() {
	   return listOfProducts;
   }
   
    
	public static void setInstance(ProductRepository instance) {
	ProductRepository.instance = instance;
}
	public ProductRepository() {
		Product phone = new Product("P1234","iPhone 6s", 800000);
		phone.setDescription("4.7-inch,1334X750 Renina IID display, 8megapixel iSight Camera");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		notebook.setDescription("13.3-inch, IpS LED display, 5rd Generation Intel Core processors");
		notebook.setCategory("Notebook");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Returbished");
		
		Product tablet = new Product("P1236", "Galaxy Tab 5", 900000);
		tablet.setDescription("212.8*125.6*6.6mm, super AmoLed display, OctaCore processor");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Samsung");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		
		//7장 코드 추가 
		phone.setFilename("P1234.JPG");
		notebook.setFilename("P1235.JPG");
		tablet.setFilename("P1236.JPG");
		//----o----
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}

	
	
//	이밑은 5장에서 사용
	public Product getProductById(String productId) { 
		Product productById=null;
		
		for(int i=0; i<listOfProducts.size();i++) {
			Product product=listOfProducts.get(i);
			if(product!=null && product.getProductId()!=null &&
					product.getProductId().equals(productId)) {
				productById=product;
				break;
			}
		}
		return productById;
	}
   
}
