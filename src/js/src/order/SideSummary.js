import * as React from 'react';
import type {Product} from "../AppState";


type Props = {
	selectedProducts: string
}

export class SideSummary extends React.PureComponent<Props> {

	render() {

		let style = {
			background:"white",
			width:300
		}

		return (
			<div style={style}>
				<h4>Shopping Cart : </h4>
				<table>
				{
					this.props.selectedProducts.map((elem: Product)=>{
						return <tr><td>{elem.name}</td><td>{elem.price}</td><td>{elem.quantity > 1 ? elem.quantity : " "}</td><td> {priceTimesQty(elem.price, elem.quantity)}</td></tr>
					})
				}
					<tr><td></td><td>TOTAL:</td><td></td><td>{calculateTotal(this.props.selectedProducts)}</td></tr>
				</table>
			</div>
		);
	}
}

function priceTimesQty(p, qty) {
	return p * qty
}

function calculateTotal(selectedProducts) {

	let t = selectedProducts.reduce((acc, cur: Product)=> {
		return acc + (cur.quantity * cur.price);
	}, 0)

	t = t.toFixed(2);
	return t
}

export default SideSummary;