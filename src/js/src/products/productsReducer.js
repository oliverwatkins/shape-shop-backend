import {Actions} from './productActions';

export function reducer(state = initialState, action) {

	console.info("xx in reducer with action " + action.type + " data " + action.data)

	switch (action.type) {

		case Actions.FETCH_PRODUCTS_SUCCESS:
			// alert("mofo! Got the prods ")


			return {
				...state,
				items: action.data,
			};

		default :
			return state;
	}
}

const initialState = {
	items: []

	// products: {
	// 	items: []
	// }
};
