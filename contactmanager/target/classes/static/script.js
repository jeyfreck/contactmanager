const API_URL = "http://localhost:8080/api/contacts";
const contactList = document.getElementById("contactList");
const contactForm = document.getElementById("contactForm");

async function loadContacts() {
  contactList.innerHTML = "";
  const res = await fetch(API_URL);
  const contacts = await res.json();

  contacts.forEach(contact => {
    const li = document.createElement("li");
    li.innerHTML = `
      <div>
        <strong>${contact.name}</strong><br/>
        📧 ${contact.email}<br/>
        📱 ${contact.phone}
      </div>
      <button onclick="deleteContact(${contact.id})">❌</button>
    `;
    contactList.appendChild(li);
  });
}

contactForm.addEventListener("submit", async (e) => {
  e.preventDefault();

  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const phone = document.getElementById("phone").value.trim();

  await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, email, phone })
  });

  contactForm.reset();
  loadContacts();
});

async function deleteContact(id) {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
  loadContacts();
}

loadContacts();
