import React from "react";

export default function SearchField(props) {

    function handleChange(e) {
        if (e.target.value === '') {
            props.onClear()
            return
        }

        props.onChange(e.target.value)
    }

    return (
        <div className="form-outline">
            <input
                type="search"
                id="searchField"
                className="form-control"
                placeholder="Введите запрос..."
                aria-label="Search"
                onChange={(e) => handleChange(e)}
            />
        </div>
    )
}