import React from "react";
import {formatDate} from "../../../utils/DateUtils";

export default function AwardRow(props) {

    return (
        <tr>
            <th scope="col">{props.award.text}</th>
            <th>{formatDate(props.award.dateRecieve)}</th>
            <th>{props.award.giverOrganization}</th>
        </tr>
    )
}