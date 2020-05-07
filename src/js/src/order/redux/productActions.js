
export function createFetchProductsAction() {
	return {
		type: Actions.FETCH_PRODUCTS,
	};
}

export function createFetchProductsSuccessAction(data) {
	return {
		type: Actions.FETCH_PRODUCTS_SUCCESS,
		data,
	};
}


export function createUpdateProductSelection(value, id) {
	return {
		type: Actions.UPDATE_PRODUCT_SELECTION,
		value: value,
		id: id
	};
}

export function createUpdateAddress(value, id) {
	return {
		type: Actions.UPDATE_ADDRESS,
		value: value,
		id: id
	};
}


export const Actions = {
	UPDATE_PAYMENT:'UPDATE_PAYMENT',
	UPDATE_PRODUCT_SELECTION: 'UPDATE_PRODUCT_SELECTION',
	UPDATE_ADDRESS: 'UPDATE_ADDRESS',
	FETCH_PRODUCTS: 'FETCH_PRODUCTS',
	FETCH_PRODUCTS_SUCCESS: 'FETCH_PRODUCTS_SUCCESS',
};
