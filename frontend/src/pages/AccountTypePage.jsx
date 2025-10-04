import React, { useEffect, useState } from "react";
import { getAccountTypes } from "../api/AccountTypeApi";
import AccountTypeTable from "../components/AccountTypeTable";

function AccountTypePage() {
  const [accountTypes, setAccountTypes] = useState([]);

  useEffect(() => {
    getAccountTypes()
      .then((data) => setAccountTypes(data))
      .catch((err) => console.error("Error fetching account types", err));
  }, []);

  return (
    <div>
      <h1 style={{ marginLeft: "20px" }}>Account Types</h1>
      <AccountTypeTable accountTypes={accountTypes} />
    </div>
  );
}

export default AccountTypePage;
