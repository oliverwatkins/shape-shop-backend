import * as React from 'react';
import pizza from './../assets/img/pizza.png';
import connect from "react-redux/es/connect/connect";
import {OrderWizard} from "./OrderWizard";
import {createFetchProductsAction} from "../products/productActions";

export class ItemBox extends React.PureComponent {


	constructor(props) {
		super(props);

		let product = props.product;

		this.state = {
			// select: false,
			// select: (product.id % 2 === 0 ? false : true),

			// quantity: 3,
		}

	}


	render() {

		// console.info(this.state.select)
		// console.info(this.state.quantity)

		let style = {
			border: "3px",
		}
		let border = false;


		// if (value%2 == 0)
		if (this.props.product.quantity > 0) {
			border = true;

			style.borderStyle = "dotted"
		}


		return (

			<div style={style}>
				<img className="wee-card__img" src={pizza} alt="Pic of pizza" width={90}/>
				<div>
					{this.props.product.id}
					<div>{this.props.product.quantity}</div>
					<div>{this.props.product.name}</div>
					<div><b> € {this.props.product.price}</b></div>
				</div>
				<input type="checkbox"
							 checked={this.state.select}
							 id="s"
							 onChange={this.handleChangeCheckbox}/>

				<select id="qty" onChange={this.handleChangeQuantity} value={this.props.product.quantity}>
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</div>
		);
	}


	handleChangeCheckbox = (e) => {

		console.info("here e.currentTarget.value " + e.currentTarget.value)

		console.info("e.currentTarget.checked" + e.currentTarget.checked)


		if (e.currentTarget.checked) {
			this.props.handleQ(1, this.props.product.id)
		}else {
			this.props.handleQ(0, this.props.product.id)
		}

	}

	handleChangeQuantity = (e) => {

		this.props.handleQ(e.currentTarget.value, this.props.product.id)

		// this.setState({
		//
		//
		//
		// 	quantity: e.currentTarget.value,
		// })
	}


}




// const mapStateToProps = state => {
// 	return {
// 		products: state.products,
// 	};
// };
//
// const mapDispatchToProps = dispatch => {
// 	return {
// 		changeOrder: () => {
// 			dispatch(create());
// 		},
// 	};
// };
//
// export default connect(
// 	mapStateToProps,
// 	null,
// )(ItemBox);


export default ItemBox;
