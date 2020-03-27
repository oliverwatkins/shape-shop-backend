//@flow
export function receiveCountriesList() {
	return {
		type: Actions.RECEIVE_COUNTRIES_LIST,
	};
}

export function successFeedback(data) {
	return {
		type: Actions.SUCCESS_FEEDBACK,
		data,
	};
}

export function receiveCountriesListSuccess(countries) {
	return {
		type: Actions.RECEIVE_COUNTRIES_LIST_SUCCESS,
		countries,
	};
}

export function receiveCountriesListFail() {
	return {
		type: Actions.RECEIVE_COUNTRIES_LIST_FAIL,
		countries: ['DE'],
	};
}

export function receiveLanguageListFail() {
	return {
		type: Actions.RECEIVE_LANGUAGE_LIST_FAIL,
	};
}

export function receiveLanguage({ country, language }) {
	return {
		type: Actions.RECEIVE_LANGUAGE,
		country,
		language,
	};
}

export function receiveLanguageListSuccess(languages) {
	return {
		type: Actions.RECEIVE_LANGUAGE_LIST_SUCCESS,
		languages,
	};
}

export function receiveLanguageSuccess({ country, language, keys, fallback }) {
	return {
		type: Actions.RECEIVE_LANGUAGE_SUCCESS,
		country,
		language,
		keys,
		fallback,
	};
}

export function receiveLanguageFail() {
	return {
		type: Actions.RECEIVE_LANGUAGE_FAIL,
	};
}

export function resetLanguageFallback() {
	return {
		type: Actions.RESET_LANGUAGE_FALLBACK,
	};
}

export function receiveCustomerDetails(Authorization, role) {
	return {
		type: Actions.RECEIVE_CUSTOMER_DETAILS,
		Authorization,
		role,
	};
}

export function receiveCustomerDetailsSuccess(data) {
	return {
		type: Actions.RECEIVE_CUSTOMER_DETAILS_SUCCESS,
		data,
	};
}

export function getMerchantDetails(Authorization, role) {
	return {
		type: Actions.GET_MERCHANT_DETAILS,
		Authorization,
		role,
	};
}
export function getMerchantDetailsSuccess(data) {
	return {
		type: Actions.GET_MERCHANT_DETAILS_SUCCESS,
		data,
	};
}

export function getCategories() {
	return {
		type: Actions.GET_CATEGORIES,
	};
}

export function getCategoriesSuccess(data) {
	return {
		type: Actions.GET_CATEGORIES_SUCCESS,
		data,
	};
}

export function getCategoriesFail() {
	return {
		type: Actions.GET_CATEGORIES_FAIL,
	};
}

export const Actions = {
	SUCCESS_FEEDBACK: 'SUCCESS_FEEDBACK',
	RECEIVE_LANGUAGE_LIST_SUCCESS: 'RECEIVE_LANGUAGE_LIST_SUCCESS',
	RECEIVE_LANGUAGE_LIST_FAIL: 'RECEIVE_LANGUAGE_LIST_FAIL',
	RECEIVE_COUNTRIES_LIST: 'RECEIVE_COUNTRIES_LIST',
	RECEIVE_COUNTRIES_LIST_SUCCESS: 'RECEIVE_COUNTRIES_LIST_SUCCESS',
	RECEIVE_COUNTRIES_LIST_FAIL: 'RECEIVE_COUNTRIES_LIST_FAIL',
	RECEIVE_LANGUAGE: 'RECEIVE_LANGUAGE',
	RECEIVE_LANGUAGE_SUCCESS: 'RECEIVE_LANGUAGE_SUCCESS',
	RECEIVE_LANGUAGE_FAIL: 'RECEIVE_LANGUAGE_FAIL',
	RESET_LANGUAGE_FALLBACK: 'RESET_LANGUAGE_FALLBACK',
	RECEIVE_CUSTOMER_DETAILS: 'RECEIVE_CUSTOMER_DETAILS',
	RECEIVE_CUSTOMER_DETAILS_SUCCESS: 'RECEIVE_CUSTOMER_DETAILS_SUCCESS',
	GET_MERCHANT_DETAILS: 'GET_MERCHANT_DETAILS',
	GET_MERCHANT_DETAILS_SUCCESS: 'GET_MERCHANT_DETAILS_SUCCESS',
	GET_CATEGORIES: 'GET_CATEGORIES',
	GET_CATEGORIES_SUCCESS: 'GET_CATEGORIES_SUCCESS',
	GET_CATEGORIES_FAIL: 'GET_CATEGORIES_FAIL',

	FETCH_TRANSLATIONS: 'FETCH_TRANSLATIONS',
	FETCH_TRANSLATIONS_SUCCESS: 'FETCH_TRANSLATIONS_SUCCESS',
	FETCH_TRANSLATIONS_FAIL: 'FETCH_TRANSLATIONS_FAIL',
	LOGIN: 'LOGIN',
	LOGIN_SUCCESS: 'LOGIN_SUCCESS',
	LOGIN_FAIL: 'LOGIN_FAIL',
	LOGOUT: 'LOGOUT',
	LOGOUT_SUCCESS: 'LOGOUT_SUCCESS',
	USER_DETAILS_RECEIVED: 'USER_DETAILS_RECEIVED',

};
