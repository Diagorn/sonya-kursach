import React from "react";
import {Link} from "react-router-dom";

export default function BackButton(props) {
    return (
        <Link to={props.to}>
            <button type="button" className="btn btn-light">Назад</button>
        </Link>
    )
}