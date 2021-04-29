import {message} from 'antd';

export const get = (url) => {
    let header = new Headers();
    let Authorization = localStorage.getItem("Authorization");
    if (Authorization && Authorization !== "") {
        header.append("Authorization", Authorization);
    }
    return fetch(url, {
        method: 'GET',
        headers: header
    }).then(response => {
        switch (response.status) {
            case 401:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 403:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 404:
                message.error('Không thể tìm thấy đường dẫn tại máy chủ!');
                return response.json();
            case 500:
                message.error('Lỗi máy chủ!');
                return response.json();
            default:
                return response.json();
        }
    }).catch(err => {
        console.log('Error :-S', err);
    });
}

export const post = (url, body) => {
    let header = new Headers();
    let Authorization = localStorage.getItem("Authorization");
    if (Authorization && Authorization !== "") {
        header.append("Authorization", Authorization);
    }
    return fetch(url, {
        method: 'POST',
        body: JSON.stringify(body),
        headers: header
    }).then(response => {
        switch (response.status) {
            case 401:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 403:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 404:
                message.error('Không thể tìm thấy đường dẫn tại máy chủ!');
                return response.json();
            case 500:
                message.error('Lỗi máy chủ!');
                return response.json();
            default:
                return response.json();
        }
    }).catch(err => {
        console.log('Error :-S', err);
    });
}

export const put = (url, body) => {
    let header = new Headers();
    let Authorization = localStorage.getItem("Authorization");
    if (Authorization && Authorization !== "") {
        header.append("Authorization", Authorization);
    }
    return fetch(url, {
        method: 'PUT',
        body: JSON.stringify(body),
        headers: header
    }).then(response => {
        switch (response.status) {
            case 401:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 403:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 404:
                message.error('Không thể tìm thấy đường dẫn tại máy chủ!');
                return response.json();
            case 500:
                message.error('Lỗi máy chủ!');
                return response.json();
            default:
                return response.json();
        }
    }).catch(err => {
        console.log('Error :-S', err);
    });
}

export const destroy = (url, body) => {
    let header = new Headers();
    let Authorization = localStorage.getItem("Authorization");
    if (Authorization && Authorization !== "") {
        header.append("Authorization", Authorization);
    }
    return fetch(url, {
        method: 'DELETE',
        body: JSON.stringify(body),
        headers: header
    }).then(response => {
        switch (response.status) {
            case 401:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 403:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 404:
                message.error('Không thể tìm thấy đường dẫn tại máy chủ!');
                return response.json();
            case 500:
                message.error('Lỗi máy chủ!');
                return response.json();
            default:
                return response.json();
        }
    }).catch(err => {
        console.log('Error :-S', err);
    });
}

export const upload = (url, formData = new FormData()) => {
    let header = new Headers();
    let Authorization = localStorage.getItem("Authorization");
    if (Authorization && Authorization !== "") {
        header.append("Authorization", Authorization);
    }
    return fetch(url, {
        method: 'POST',
        body: formData,
        headers: header
    }).then(response => {
        switch (response.status) {
            case 401:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 403:
                message.error('Không có quyền thực hiện!');
                localStorage.setItem("Authorization", "");
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 404:
                message.error('Không thể tìm thấy đường dẫn tại máy chủ!');
                return response.json();
            case 500:
                message.error('Lỗi máy chủ!');
                return response.json();
            default:
                return response.json();
        }
    }).catch(err => {
        console.log('Error :-S', err);
    });
}


export const download = (url) => {
    let header = new Headers();
    let Authorization = localStorage.getItem("Authorization");
    if (Authorization && Authorization !== "") {
        header.append("Authorization", Authorization);
    }
    fetch(url, {
        method: 'GET',
        headers: header
    }).then(response => {
        switch (response.status) {
            case 401:
                localStorage.setItem("Authorization", "");
                message.error('Không có quyền thực hiện!');
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 403:
                localStorage.setItem("Authorization", "");
                message.error('Không có quyền thực hiện!');
                window.location.href = window.location.origin + "/login";
                return response.json();
            case 404:
                message.error('Không thể tìm thấy đường dẫn tại máy chủ!');
                return response.json();
            case 500:
                message.error('Lỗi máy chủ!');
                return response.json();
            default:
                return response.blob();
        }
    }).then((blob) => {
        if (blob) {
            const file = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = file;
            a.download = url.split("/")[url.split("/").length - 1];
            document.body.appendChild(a);
            a.click();
            a.remove();
        } else {
            message.error("Không tìm thấy file!");
        }
    }).catch(err => {
        console.log('Error :-S', err);
    });
}
