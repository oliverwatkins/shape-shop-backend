//@flow
export type AppState = {
	products: {
		items: Array<Product>
	},
	user: Function,
};


export type Product = {
	name: string,
	quantity: number,
	price: string,
	description: string
}