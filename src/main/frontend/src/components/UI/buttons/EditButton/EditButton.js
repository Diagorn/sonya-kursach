import React from "react";

export default function EditButton(props) {
    return <button type="button"
                   className={`btn btn-warning ${props.className}`}
                   onClick={props.btnCallback}>
        {props.label ? props.label : 'Изменить'}
    </button>
}