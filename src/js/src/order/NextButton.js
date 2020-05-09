import * as React from 'react';
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";

type Props = {
	label: "string",
	page?: "string",
	type?: "string", //submit?
	form?: "string" //form id
}

export function NextButton(props: Props) {
	return (
		<button className={"nextButton"} type={props.type} form={props.form}>
			<div style={{display: "flex", fontSize: "65px"}}>
				<div style={{color: "gray", fontSize: "65px"}}>
					{props.label}
				</div>
				{props.page &&
				<Link to={props.page}>
					<div>
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
					</div>
				</Link>
				}
				{!props.page &&
					<div>
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
					</div>
				}
			</div>
		</button>
	);
}
