// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val products = this.customers.flatMap { it.getOrderedProducts() }.toSet()
    return this.customers.fold(products) { allProducts, customer -> allProducts.intersect(customer.orders.flatMap { it.products }.toSet()) }
}

fun Customer.getOrderedProducts(): List<Product> =
        //this.customers.flatMap { it.orders }.flatMap { it.products }.toSet()
        this.orders.flatMap { it.products }