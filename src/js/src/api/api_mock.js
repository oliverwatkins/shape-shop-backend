

/**
 * Mock API for running/testing my-wee standalone.
 */
const create = () => {
	const BUSINESS_TOKEN =
		'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiTUVSQ0hBTlQiLCJleHAiOjE1NTAyNDc5MjAsInN0YXR1cyI6ImFjdGl2ZSJ9.Y0Qg1meZb2t7fUFLJ9l0WN-smsN1Wrg7bgXVlKLA26O2SM5l_NYGQ6NXy3d16QGAiyFOyV0wKN6DvDjDfUPn5g';
	const CUSTOMER_TOKEN =
		'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiQ1VTVE9NRVIiLCJleHAiOjE1NDk1NTMxMjd9.U3LaGUbk8oq9sGB_PCzh05i1Xwlat2vAOa7x2toCM6pIUWx4_4eZoWIFRtj9nPBBvpBbxX7NcbFjrv2C1lkpAw';

	const loginUser = credentials => {
		let response = {
			ok: true,
			status: 200,
			headers: {
				authorization: BUSINESS_TOKEN,
			},
		};
		return response;
	};

	const logoutUser = Authorization => {
		return 'todo';
	};

	const customerDetails = Authorization => {
		return {
			status: 200,
			data: {
				email: "asdf@asdf.com",
				lastName: "asdfasdf"
			},
		};
	};

	const merchantDetails = Authorization => {
		return {
			status: 200,
			data: {
				email: "asdf@asdf.com",
				lastName: "asdfasdf"
			},
		};
	};


	const validateDetails = data => {
		return {
			ok: true,
		};
	};

	const validateBusinessDetails = data => {
		return {
			ok: true,
		};
	};

	const registrationConfirmation = data => {
		return {
			ok: true,
		};
	};

	const registrationConfirmationBusiness = data => {
		return {
			ok: true,
		};
	};


	return {
		// setBaseURL,
		loginUser,
	};
};

export default {
	create,
};
