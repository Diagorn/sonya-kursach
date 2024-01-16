import React from "react";
import AwardRow from "../AwardTableRow/AwardRow";

export default function AwardTable(props) {

    return (
        <table className="table table-striped">
            <thead>
            <tr>
                <th scope="col">Текст</th>
                <th scope="col">Дата вручения</th>
                <th scope="col">Выдавшая организация</th>
            </tr>
            </thead>
            <tbody>
            {
                props.awards.map(award => {
                    return <AwardRow
                        award={award}
                        key={award.text}
                    />
                })
            }
            </tbody>
        </table>
    )
}