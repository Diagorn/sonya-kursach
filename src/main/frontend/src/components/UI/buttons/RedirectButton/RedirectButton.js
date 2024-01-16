import React from "react";

export default function RedirectButton(props) {
    return <button type="button"
                   className={`btn btn-info ${props.className}`}>
        {props.label ? props.label : 'Перейти'}
    </button>
}