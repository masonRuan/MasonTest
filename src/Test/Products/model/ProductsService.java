package Test.Products.model;

import java.util.List;

public class ProductsService {
	ProductsDAO dao = new ProductsDAO();

	public List<ProductsVO> read_Products() {
		return dao.read_Products();
	}

	public void create_Products(String prod_Name, Integer prod_Price) {
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProd_Name(prod_Name);
		productsVO.setProd_Price(prod_Price);
		dao.create_Products(productsVO);
	}

	public void update_Products(Integer prod_ID, String prod_Name,
			Integer prod_Price, Integer prod_Status) {
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProd_ID(prod_ID);
		productsVO.setProd_Name(prod_Name);
		productsVO.setProd_Price(prod_Price);
		productsVO.setProd_Status(prod_Status);
		dao.update_Products(productsVO);
	}

	public void delete_Products(Integer prod_ID, String prod_Name,
			Integer prod_Price, Integer prod_Status) {
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProd_ID(prod_ID);
		productsVO.setProd_Name(prod_Name);
		productsVO.setProd_Price(prod_Price);
		productsVO.setProd_Status(prod_Status);
		dao.delete_Products(productsVO);
	}
}
