import {Actions} from './actions';

export function reducer(state = initialState, action) {

	switch (action.type) {

		case Actions.LOGIN_SUCCESS:
			return {
				...state,
				loginToken: action.token,
				loggingIn: false,
				role: action.role,
				logout: null,
			};
		case Actions.LOGIN_FAIL:
			return {
				...state,
				loggingIn: false,
			};
		case Actions.LOGOUT:
			return {
				...state,
				logout: 'IN_PROGRESS',
			};
		case Actions.LOGOUT_SUCCESS:
			return {
				loginToken: {},
			};
		default :
			return state;
	}
}

const initialState = {
	loggingIn: false,
	loginToken: {},
};
