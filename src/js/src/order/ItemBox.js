import * as React from 'react';
import pizza from './../assets/img/pizza.png';
import connect from "react-redux/es/connect/connect";
import {OrderWizard} from "./OrderWizard";
import {createFetchProductsAction} from "../products/productActions";

export class ItemBox extends React.PureComponent {

	constructor(props) {
		super(props);

		this.state = {}
	}

	render() {
		let selected = ""

		if (this.props.product.quantity > 0) {
			selected = "selected"
		}

		return (
			<div className={selected}>
				<img src={pizza} alt="Pic of pizza" width={120}/>
				<div>
					<div>{this.props.product.name}</div>
					<div><b> € {this.props.product.price}</b></div>
				</div>
				<input type="checkbox"
							 checked={this.state.select}
							 id="selectCheckbox"
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
		if (e.currentTarget.checked) {
			this.props.handleQ(1, this.props.product.id)
		}else {
			this.props.handleQ(0, this.props.product.id)
		}
	}

	handleChangeQuantity = (e) => {
		this.props.handleQ(e.currentTarget.value, this.props.product.id)
	}
}

export default ItemBox;