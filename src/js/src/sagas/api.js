


const create = (api) => {

	const setBaseURL = (baseUrl) => {
		api.setBaseURL(baseUrl);
	};

	const loginUser = (credentials) => {
		return api.post('/login', credentials).then(response => {
			return response;
		});
	};


	const customerDetails = (Authorization) => {
		api.setHeaders({ ...Authorization });

		return api.get('/customers').then(response => response);
	};

	const logoutUser = (Authorization) => {
		api.setHeaders({ ...Authorization });

		return api.post('/logout').then(response => {
			return response;
		});
	};



	return {
		setBaseURL,
		loginUser,
	};
};

// let's return back our create method as the default.
export default {
	create,
};
