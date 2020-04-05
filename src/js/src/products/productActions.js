
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

export const Actions = {
	FETCH_PRODUCTS: 'FETCH_PRODUCTS',
	RECEIVE_SHOPS_FAIL: 'RECEIVE_SHOPS_FAIL',
	FETCH_PRODUCTS_SUCCESS: 'FETCH_PRODUCTS_SUCCESS',
};
