import * as React from 'react';
import ProductSelection from "./ProductSelection";
import OrderSummary from "./OrderSummary";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleRight, faArrowCircleLeft} from "@fortawesome/free-solid-svg-icons";
import {Formik} from "formik";


//redundant
export class Address extends React.PureComponent {
	render() {
		return (
			<div style={{display: "flex"}} className="wizardPanel">

				<Link to="/order/productlist">
					<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize: "100px", color: "gray"}}/>
				</Link>


				<div className="address">
					<h2>Delivery or Pickup?</h2>




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
						onSubmit={(values, {setSubmitting}) => {
							setTimeout(() => {
								alert(JSON.stringify(values, null, 2));
								setSubmitting(false);
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
							<form onSubmit={handleSubmit}>
								<div>
									Name
									<input
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

									Strasse
									<input
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

									Postleitzahl
									<input
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

									Telefon
									<input
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
									Email
									<input
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


				<div className={"aside"}>
					<Link to="/order/payment">
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
					</Link>
				</div>
			</div>
		);
	}
}

export default Address;
