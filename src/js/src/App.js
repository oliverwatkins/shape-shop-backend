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
import LoginScreen from "./login/LoginScreen";
import {createFetchProductsAction} from "./products/productActions";
import {MainNav} from "./MainNav";

import "./main.scss"

import "./css.scss"


import "./icons.scss"

import OrderWizard from "./order/OrderWizard";
import Footer from "./Footer";




class App extends React.PureComponent{
	componentDidMount() {
			this.props.fetchProducts();
	}

	render() {
		return (
			<div className="App">
				<Router>
					<div>
						<MainNav/>
						<Switch>
							<Route path="/admin">
								<AdminScreen/>
							</Route>

							<Route path="/order/productlist">
								<OrderWizard/>
							</Route>

							<Route path="/login">
								<LoginScreen/>
							</Route>
							<Route path="/">
								<Welcome/>
							</Route>
						</Switch>
					</div>
				</Router>

				<Footer></Footer>
			</div>
		);
	}
}

const mapStateToProps = state => {
	return {
		login: state.login,
	};
};

const mapDispatchToProps = dispatch => {
	return {
		fetchProducts: () => {
			dispatch(createFetchProductsAction());
		},
	};
};

export default connect(
	mapStateToProps,
	mapDispatchToProps,
)(App);
