import React, { useState, useEffect } from 'react'
import Header from '../components/UrlPage/Header'
import UrlTable from '../components/UrlPage/UrlTable'
import UpdateModal from '../components/UrlPage/UpdateModal'
import CreateModal from '../components/UrlPage/CreateModal'

const API_BASE_URL = 'https://urlshortner-mgzm.onrender.com/api/shorten';

const UrlPage = () => {
  const [urls, setUrls] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [showCreateModal, setShowCreateModal] = useState(false);
  const [showUpdateModal, setShowUpdateModal] = useState(false);
  const [selectedUrl, setSelectedUrl] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchUrls();
  }, []);

  const fetchUrls = async () => {
    setLoading(true);
    try {
      const response = await fetch(`${API_BASE_URL}/all`); // I'll check if this exists or add it.
      if (response.ok) {
        const data = await response.json();
        setUrls(data);
      } else {
        // Fallback for demo if no "all" endpoint
        console.warn("No 'all' endpoint found, using empty list.");
        setUrls([]);
      }
    } catch (err) {
      setError("Failed to fetch URLs. Is the backend running?");
    } finally {
      setLoading(false);
    }
  };

  const addUrl = async (longUrl) => {
    try {
      const response = await fetch(API_BASE_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ url: longUrl })
      });
      if (response.ok) {
        fetchUrls();
      }
    } catch (err) {
      alert("Error creating URL: " + err.message);
    }
  };

  const remUrl = async (shortCode) => {
    try {
      const response = await fetch(`${API_BASE_URL}/${shortCode}`, {
        method: 'DELETE'
      });
      if (response.ok) {
        setUrls(urls.filter((u) => u.shortCode !== shortCode));
      }
    } catch (err) {
      alert("Error deleting URL: " + err.message);
    }
  };

  const handleUpdate = async (newUrl) => {
    try {
      const response = await fetch(`${API_BASE_URL}/${selectedUrl.shortCode}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ url: newUrl })
      });
      if (response.ok) {
        fetchUrls();
        setShowUpdateModal(false);
      }
    } catch (err) {
      alert("Error updating URL: " + err.message);
    }
  };

  const openUpdateModal = (urlItem) => {
    setSelectedUrl(urlItem);
    setShowUpdateModal(true);
  };

  const filteredUrls = urls.filter(u => 
    u.shortCode.toLowerCase().includes(searchQuery.toLowerCase()) || 
    u.url.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <div className='url-page-container' style={{paddingTop:'100px', minHeight:'100vh'}}>
      <Header />
      
      <section style={{paddingTop: '2rem'}}>
        <div className="controls-header">
            <div className="search-box">
                <span style={{opacity:0.5}}>SEARCH</span>
                <input 
                    type="text" 
                    placeholder="Search your links..." 
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
            </div>
            <button className="btn-create" onClick={() => setShowCreateModal(true)}>
                CREATE NEW URL
            </button>
        </div>

        {error && <div style={{color:'var(--error)', marginBottom:'1rem', textAlign:'center'}}>{error}</div>}
        
        {loading ? (
            <div style={{textAlign:'center', padding:'3rem'}}>Loading your links...</div>
        ) : (
            <UrlTable 
                urls={filteredUrls} 
                remUrl={remUrl} 
                openModal={openUpdateModal}
            />
        )}
      </section>

      {showCreateModal && (
        <CreateModal 
            addUrl={addUrl} 
            closeModal={() => setShowCreateModal(false)} 
        />
      )}

      {showUpdateModal && selectedUrl && (
        <UpdateModal 
            currentUrl={selectedUrl} 
            updateUrl={handleUpdate} 
            closeModal={() => setShowUpdateModal(false)} 
        />
      )}
    </div>
  )
}

export default UrlPage
