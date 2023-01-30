package com.ssafy.ws.step4;

public class ProductTest {

	public static void main(String[] args) {
		ProductManager pm = ProductManager.getInstance();
		pm.addProduct(new Refrigerator("R0001", "S냉장고", 1000000, 20, "삼성", "삼성에서 출시한 스마트냉장고입니다.", "냉장고", 1000, true, 2021));
	    pm.addProduct(new Refrigerator("R0002", "L냉장고", 100000, 10, "앨리스", "앨리스 저가형 냉장고.", "냉장고", 300, false, 2022));
	    pm.addProduct(new Refrigerator("R0003", "T냉장고", 3000000, 200, "로보", "로보에서 출시한 AI냉장고입니다.", "냉장고", 1200, true, 2022));
	    pm.addProduct(new Refrigerator("R0004", "K냉장고", 500000, 50, "코라", "코라에서 출시한 보급형냉장고입니다.", "냉장고", 700, false, 2021));
	    pm.addProduct(new Refrigerator("R0005", "A냉장고", 1000000, 10, "에이스", "에이스에서 출시한 스마트냉장고입니다.", "냉장고", 800, true, 2022));
	    pm.addProduct(new Product("P0001", "우주폰S", 500000, 100, "삼성", "삼성에서 출시한 우주폰S입니다."));
		
		
		
		System.out.println("******************냉장고 목록******************");
		for(Refrigerator r : pm.getRefrigerator()) {
			System.out.println(r);
		}
		
		System.out.println("******************냉동고 있는 목록******************");
		for(Refrigerator r : pm.getRefrigeratorsFreezer(true)) {
			System.out.println(r);
		}
		
		System.out.println("******************이름 검색******************");
		for(Product p : pm.searchByName("S")) {
			if(p instanceof Refrigerator) {
				Refrigerator fr = (Refrigerator) p;
				System.out.println(fr.toString());
			}else {
				System.out.println(p.toString());
			}
		}
		
		System.out.println("******************재고 총가격******************");
		System.out.println(pm.getTotalPrice() + "");
	}

}
