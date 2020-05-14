import * as React from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTruck} from "@fortawesome/free-solid-svg-icons";
import {Formik} from "formik";

import "./order.scss"
import {Redirect} from "react-router";
import {createUpdateAddress} from "./redux/productActions";
import connect from "react-redux/es/connect/connect";
import {wizardPages as pages} from "./OrderWizard"
import {NextButton} from "./NextButton";
import {BackButton} from "./BackButton";

export class Address extends React.PureComponent {

	state = {
		redirect: false,
		pickup: true,
		delivery: false
	}

	setRedirect = () => {
		this.setState({
			redirect: true
		})
	}

	onPickupChanged = (e) => {
		this.setState({
			pickup: e.currentTarget.value === 'pickup',
			delivery:false
		});
	}

	onDeliveryChanged = (e) => {
		this.setState({
			delivery: e.currentTarget.value === 'delivery',
			pickup: false
		});
	}


	render() {
		if (this.state.redirect) {
			return <Redirect to={pages.WHICH_PAYMENT}/>
		}

		return (
			<div className="wizardPanel">

				<BackButton page={pages.PRODUCT_LIST}/>

				<div className="wizardInner">

					<h2 className={"wizardHeader"}>Delivery or Pickup?</h2>

					<div className="icon-container">
						<FontAwesomeIcon icon={faTruck} style={{fontSize: "60px", color: "navy"}}/>
					</div>

					<div>
						<input type="radio"
									 id="contactChoice1"
									 name="pckupOrDelivery"
									 value="pickup"
									 onChange={this.onPickupChanged}
									 checked={this.state.pickup}/>
						<label htmlFor="contactChoice1">Pickup</label>

						<input type="radio"
									 id="contactChoice2"
									 name="pckupOrDelivery"
									 value="delivery"
									 checked={this.state.delivery}
									 onChange={this.onDeliveryChanged}
						/>
						<label htmlFor="contactChoice2">Delivery</label>
					</div>

					{this.state.delivery && !this.state.pickup &&
					<Formik
						initialValues={{email: '', password: '', name: ''}}
						validate={validator}
						onSubmit={(values, blah) => {
							setTimeout(() => {
								// alert(JSON.stringify(values, null, 2));
								blah.setSubmitting(false);

								this.props.updateAddress(values);
								this.setRedirect()
							}, 400);
						}}>

						{({values, errors, touched, handleChange, handleBlur, handleSubmit, isSubmitting}) => (
							<form onSubmit={handleSubmit} id="addressForm">
								<div>
									<label htmlFor="name">Name</label>
									<input
										id="name"
										type="text"
										name="name"
										onChange={handleChange}
										onBlur={handleBlur}
										value={values.name}
									/>
									<span className={"error"}>
									{errors.name && touched.name && errors.name}
									</span>
								</div>
								<div>
									<label htmlFor="street">Strasse</label>
									<input
										id="street"
										type="text"
										name="street"
										onChange={handleChange}
										onBlur={handleBlur}
										value={values.street}
									/>
									<span className={"error"}>
									{errors.street && touched.street && errors.street}
									</span>
								</div>
								<div>
									<label htmlFor="postcode">Postleitzahl</label>
									<input
										id="postcode"
										type="text"
										name="postcode"
										onChange={handleChange}
										onBlur={handleBlur}
										value={values.postcode}
									/>
									<span className={"error"}>
									{errors.postcode && touched.postcode && errors.postcode}
									</span>
								</div>
								<div>
									<label htmlFor="tel">Telefon</label>
									<input
										id="tel"
										type="text"
										name="telephone"
										onChange={handleChange}
										onBlur={handleBlur}
										value={values.telephone}
									/>
									<span className={"error"}>
									{errors.telephone && touched.telephone && errors.telephone}
									</span>
								</div>
								<div>
									<label htmlFor="email">Email</label>
									<input
										id="email"
										type="email"
										name="email"
										onChange={handleChange}
										onBlur={handleBlur}
										value={values.email}
									/>
									<span className={"error"}>
									{errors.email && touched.email && errors.email}
									</span>
								</div>
								<button type="submit" disabled={isSubmitting}>
									Submit
								</button>
							</form>
						)}
					</Formik>
					}
				</div>
				{this.state.delivery && !this.state.pickup &&
				<NextButton label={"NEXT"} type={"submit"} form={"addressForm"}/> }
				{!this.state.delivery && this.state.pickup &&
				<NextButton label={"NEXT"} page={pages.WHICH_PAYMENT}/> }
			</div>
		);
	}
}


let validator = (values) => {
	const errors = {};

	if (!values.name) {
		errors.name = 'Name Required';
	}

	if (!values.email) {
		errors.email = 'Required';
	} else if (
		!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
	) {
		errors.email = 'Invalid email address';
	}
	return errors;
}

const mapDispatchToProps = dispatch => {
	return {
		updateAddress: (value, id) => {
			dispatch(createUpdateAddress(value, id));
		},
	};
};

export default connect(
	null,
	mapDispatchToProps,
)(Address);