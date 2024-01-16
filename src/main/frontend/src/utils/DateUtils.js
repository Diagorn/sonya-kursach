export function parseTimestamp(timestamp) {
    if (!timestamp) {
        return null
    }

    let year = timestamp.substring(0, 4)
    let month = timestamp.substring(5, 7)
    let day = timestamp.substring(8, 10)
    let hours = timestamp.substring(11, 13)
    let minutes = timestamp.substring(14, 16)
    let seconds = timestamp.substring(17, 19)

    return new Date(Number(year), Number(month), Number(day),
        Number(hours), Number(minutes), Number(seconds))
}

export function formatTimestamp(timestamp) {
    if (!timestamp) {
        return null
    }

    const date = parseTimestamp(timestamp)
    const options = {
        year: 'numeric',
        month: 'numeric',
        day: 'numeric',
        hour: 'numeric',
        minute: 'numeric',
        second: 'numeric',
        timezone: 'UTC'
    };
    return date.toLocaleString("ru", options);
}

export function parseDate(date) {
    if (!date) {
        return null
    }

    let year = date.substring(0, 4)
    let month = date.substring(5, 7)
    let day = date.substring(8, 10)

    return new Date(Number(year), Number(month), Number(day))
}

export function formatDate(date) {
    if (!date) {
        return null
    }

    const parsedDate = parseDate(date)
    const options = {
        year: 'numeric',
        month: 'numeric',
        day: 'numeric',
        timezone: 'UTC'
    }

    return parsedDate.toLocaleString("ru", options)
}