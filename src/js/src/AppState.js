//@flow
export type AppState = {
	products: {
		items: Array<Product>,
	},
	order: OrderState,
	login: {
	},
	user: Function, //??
};


export type OrderState = {
	address: {
		name: string,
		telephone: string,
		street: string,
		postcode: string,
		email: string
	}
}


export type Product = {
	name: string,
	quantity: number,
	price: string,
	description: string
}



