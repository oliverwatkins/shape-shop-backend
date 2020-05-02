
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


export const Actions = {
	UPDATE_PRODUCT_SELECTION: 'UPDATE_PRODUCT_SELECTION',
	FETCH_PRODUCTS: 'FETCH_PRODUCTS',
	RECEIVE_SHOPS_FAIL: 'RECEIVE_SHOPS_FAIL',
	FETCH_PRODUCTS_SUCCESS: 'FETCH_PRODUCTS_SUCCESS',
};
