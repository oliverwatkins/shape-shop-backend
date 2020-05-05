import React from 'react';

import {connect} from 'react-redux';

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Welcome from "./WelcomeScreen";
import AdminScreen from "./AdminScreen";
import LoginScreen from "./login/LoginScreen";
import {createFetchProductsAction} from "./products/productActions";
import {MainNav} from "./MainNav";

import "./main.scss"

import "./alpenhofCss.scss"


import "./icons.scss"

import OrderWizard from "./order/OrderWizard";
import Footer from "./Footer";
import Address from "./order/Address";
import Payment from "./order/Payment";
import Summary from "./order/Summary";


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


							<Route path="/order/address">
								<Address/>
							</Route>
							<Route path="/order/payment">
								<Payment/>
							</Route>
							<Route path="/order/summary">
								<Summary/>
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
