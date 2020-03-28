import React from 'react';

import { connect } from 'react-redux';

import {
	BrowserRouter as Router,
	Switch,
	Route,
	Link
} from "react-router-dom";
import Welcome from "./WelcomeScreen";
import AdminScreen from "./AdminScreen";
import UserScreen from "./UserScreen";
import LoginScreen from "./LoginScreen";

function App() {
  return (
    <div className="App">
			<Router>
				<div>
					<nav>
						<ul>
							<li>
								<Link to="/">Home</Link>
							</li>
							<li>
								<Link to="/admin">Admin</Link>
							</li>
							<li>
								<Link to="/user">Users</Link>
							</li>
							<li>
								<Link to="/login">LOGIN</Link>
							</li>
						</ul>
					</nav>
					<Switch>
						<Route path="/admin">
							<AdminScreen />
						</Route>
						<Route path="/user">
							<UserScreen />
						</Route>
						<Route path="/login">
							<LoginScreen />
						</Route>
						<Route path="/">
							<Welcome />
						</Route>
					</Switch>
				</div>
			</Router>
    </div>
  );
}

const mapStateToProps = state => {
	return {
		// countriesList: state.countriesList,
		// i18n: state.i18n,
		login: state.login,
		// userStatus: selectUserStatus(state),
		// userRole: selectUserRole(state),
	};
};

const mapDispatchToProps = dispatch => {
	return {
		fetchLanguage: params => {
			dispatch("")
		},
		fetchCountryList: () => {
			dispatch("")
			// dispatch(receiveCountriesList());
		},
	};
};

export default connect(
	mapStateToProps,
	mapDispatchToProps,
)(App);
