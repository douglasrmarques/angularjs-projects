// App Services
infobaseApp.service('productService', function(){
    this.isDisplayProductView = true;

    this.defaultProductList = [{
      productName: "Product Test Version 2.0X (2017)",
      title: "Product Test Title",
      description: "This is some description about the product you are going to buy!",
      price: 10.99,
      imgUrl: "images/prod02.png"
    },];
});
