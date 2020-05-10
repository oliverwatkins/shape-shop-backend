import {Actions} from './productActions';

export function reducer(state = initialState, action) {

	console.info("xx in reducer with action " + action.type + " data " + action.data)

	switch (action.type) {


		case Actions.UPDATE_ADDRESS:
			return {
				...state,
				address: action.value
			}
		case Actions.UPDATE_PAYMENT:
			return {
				...state,
				payment: action.values
			}
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
