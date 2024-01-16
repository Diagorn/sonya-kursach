import React from "react";

export default function DeleteButton(props) {
    return <button type="button" className="btn btn-danger" onClick={props.btnCallback}>Удалить</button>
}