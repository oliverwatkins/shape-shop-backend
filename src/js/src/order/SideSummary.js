import * as React from 'react';
import type {Product} from "../AppState";


import { faArrowCircleRight } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";



type Props = {
	selectedProducts: string
}

export class SideSummary extends React.PureComponent<Props> {

	render() {

		let style = {
			background:"white",
			width:500
		}

		let styleTD = {
			padding:"5px"
		}

		return (
			<div style={style}>
				<h4>Shopping Cart : </h4>



				<table>
				{
					this.props.selectedProducts.map((elem: Product)=>{
						return <tr><td>{elem.name}</td><td style={styleTD}>{elem.price}</td><td>{elem.quantity > 1 ? elem.quantity : " "}</td><td> {priceTimesQty(elem.price, elem.quantity)}</td></tr>
					})
				}
					<tr><td> </td><td><b>Total:</b></td><td> </td><td>{calculateTotal(this.props.selectedProducts)}</td></tr>
				</table>
			</div>
		);
	}
}

function priceTimesQty(p, qty) {
	let t = p * qty
	t = t.toFixed(2);
	return t

}

function calculateTotal(selectedProducts) {

	let t = selectedProducts.reduce((acc, cur: Product)=> {
		return acc + (cur.quantity * cur.price);
	}, 0)

	t = t.toFixed(2);
	return t
}

export default SideSummary;