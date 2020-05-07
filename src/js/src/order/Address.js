import * as React from 'react';
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleLeft, faArrowCircleRight, faTruck} from "@fortawesome/free-solid-svg-icons";
import {Formik} from "formik";

import "./order.scss"
import {Redirect} from "react-router";
import {createUpdateAddress, createUpdateProductSelection} from "./redux/productActions";
import connect from "react-redux/es/connect/connect";
import {ProductSelection} from "./ProductSelection";


export class Address extends React.PureComponent {

	state = {
		redirect: false
	}

	setRedirect = () => {
		this.setState({
			redirect: true
		})
	}

	render() {
		if (this.state.redirect) {
			return <Redirect to='/order/whichPayment' />
		}

		return (
			<div style={{display: "flex"}} className="wizardPanel">



			<button >
				<Link to="/order/productlist">
					<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize: "100px", color: "gray"}}/>
				</Link>
			</button>


				<div className="address">
					<h2>Delivery or Pickup?</h2>
					<div className="icon-container">





						<FontAwesomeIcon icon={faTruck} style={{fontSize: "60px", color: "navy"}}/>
					</div>
					<Formik
						initialValues={{email: '', password: '', name: ''}}
						validate={values => {
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
						}}


						onSubmit={(values, blah) => {

							setTimeout(() => {

								alert(JSON.stringify(values, null, 2));

								blah.setSubmitting(false);

								this.props.updateAddress(values);

								this.setRedirect()
							}, 400);
						}}
					>
						{({
								values,
								errors,
								touched,
								handleChange,
								handleBlur,
								handleSubmit,
								isSubmitting,
								/* and other goodies */
							}) => (
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
				</div>

				<button type="submit" form="addressForm" >
					<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
				</button>

				{/*<div className={"aside"}>*/}
					{/*<Link to="/order/payment">*/}
						{/*<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>*/}
					{/*</Link>*/}
				{/*</div>*/}
			</div>
		);
	}
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

