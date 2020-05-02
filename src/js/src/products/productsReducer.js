import {Actions} from './productActions';

export function reducer(state = initialState, action) {

	console.info("xx in reducer with action " + action.type + " data " + action.data)

	switch (action.type) {

		case Actions.FETCH_PRODUCTS_SUCCESS:
			return {
				...state,
				items: action.data,
			};

		case Actions.UPDATE_PRODUCT_SELECTION:
			// alert("mofo! Got the UPDATE_PRODUCT_SELECTION " + action.value + " id " + action.id)


			let foundProd = state.items.filter(item => item.id === action.id);


			let fp = foundProd[0];

			fp.quantity = action.value;

			alert(JSON.stringify(fp))


			// return Object.assign({}, state, {
			// 	confirmation: {
			// 		registering: false,
			// 		registrationConfirmed: false,
			// 	},
			// });


			return {
				...state,
				items: state.items.map((item) => {
					if (item.id === action.id) {
						return {"id": item.id,
							"name": item.name,
							"price": item.price,
							"quantity": action.value}
					}
					return item;
				}),
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
