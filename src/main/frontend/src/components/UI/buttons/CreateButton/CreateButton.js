import React from "react";

export default function CreateButton(props) {
    return <button type="button" className="btn btn-success" onClick={props.btnCallback}>Создать</button>
}