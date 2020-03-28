export const isUserLoggedIn = (state) => {
	return Boolean(state.login.loginToken && state.login.loginToken.role);
};

export const selectUserRole = (state) => {
	return state.login.loginToken.role;
};

export const selectAuthorization = (state) => {
	return state.login.loginToken.token;
};

export const selectUserEmail = (state) => {
	return state.login.loginToken.email;
};
