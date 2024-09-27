const fetchData = (url: RequestInfo, params?: RequestInit) => {
    return new Promise((resolve, reject) => {
      fetch(url, params).then(res => {
        if (res.ok) {
          res.json().then(data => resolve(data));
        } else {
          res.json().then(data => reject(data))
        }
      })
    })
}

export default fetchData;
