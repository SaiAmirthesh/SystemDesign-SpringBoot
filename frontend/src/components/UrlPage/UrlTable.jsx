import React from 'react'

const UrlTable = ({urls , remUrl , openModal}) => {
  return (
    <div className="table-container">
      <table>
        <thead>
          <tr>
            <th>Short Code</th>
            <th>Original URL</th>
            <th style={{textAlign:'center'}}>Clicks</th>
            <th style={{textAlign:'center'}}>Actions</th>
          </tr>
        </thead>

        <tbody>
            {urls.length === 0 ? (
                <tr>
                    <td colSpan="4" style={{textAlign:'center', padding:'3rem', color:'var(--text-muted)', fontSize:'0.7rem', textTransform:'uppercase', letterSpacing:'2px'}}>No URLs found. Create one.</td>
                </tr>
            ) : (
                urls.map((item,index)=>(
                    <tr key={item.id || index}>
                        <td style={{fontWeight:'700', color:'var(--text-main)', letterSpacing:'1px', textTransform:'uppercase'}}>
                            <a href={`https://urlshortner-mgzm.onrender.com/api/${item.shortCode}`} target="_blank" rel="noopener noreferrer" style={{color:'inherit', textDecoration:'none', borderBottom:'1px solid var(--border-main)'}}>
                                {item.shortCode}
                            </a>
                        </td>
                        <td style={{maxWidth:'300px', overflow:'hidden', textOverflow:'ellipsis', whiteSpace:'nowrap', color:'var(--text-muted)', fontSize:'0.9rem'}}>
                            {item.url}
                        </td>
                        <td style={{textAlign:'center'}}>
                            <span style={{padding:'4px 12px', fontSize:'0.8rem', border:'1px solid var(--border-main)', fontWeight:'700'}}>
                                {item.accessCount || 0}
                            </span>
                        </td>
                        <td style={{textAlign:'center'}}>
                            <div style={{display:'flex', gap:'4px', justifyContent:'center'}}>
                                <button className="btn-action" onClick={() => window.open(`https://urlshortner-mgzm.onrender.com/api/${item.shortCode}`, '_blank')}>
                                    OPEN
                                </button>
                                <button className="btn-action" onClick={()=>openModal(item)}>
                                    EDIT
                                </button>
                                <button className="btn-action" onClick={()=>remUrl(item.shortCode)}>
                                    DEL
                                </button>
                            </div>
                        </td>
                    </tr>
                ))
            )}
        </tbody>
      </table>
    </div>
  )
}

export default UrlTable
