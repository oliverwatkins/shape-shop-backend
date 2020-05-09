import * as React from 'react';
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleLeft, faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";
import {wizardPages as pages} from "./OrderWizard";

type Props = {
	page: "string",
}

export function BackButton(props: Props) {
	return (
		<button>
			<Link to={props.page}>
				<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize: "100px", color: "gray"}}/>
			</Link>
		</button>

	);
}
