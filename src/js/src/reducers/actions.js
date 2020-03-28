

export function createLoginAction(name, password) {
	return {
		type: Actions.LOGIN,
		user: name,
		password: password,
	};
}

export function createLoginSuccessAction(token) {
	return {
		type: Actions.LOGIN_SUCCESS,
		token: token,
	};
}

export function createLoginFailAction() {
	return {
		type: Actions.LOGIN_FAIL,
	};
}

export function createLogoutAction(token, history) {
	return {
		type: Actions.LOGOUT,
		token,
		history,
	};
}

export function createLogoutSuccessAction() {
	return {
		type: Actions.LOGOUT_SUCCESS,
	};
}

export const Actions = {
	LOGIN: 'LOGIN',
	LOGIN_SUCCESS: 'LOGIN_SUCCESS',
	LOGIN_FAIL: 'LOGIN_FAIL',
	LOGOUT: 'LOGOUT',
	LOGOUT_SUCCESS: 'LOGOUT_SUCCESS',
	USER_DETAILS_RECEIVED: 'USER_DETAILS_RECEIVED',
};
