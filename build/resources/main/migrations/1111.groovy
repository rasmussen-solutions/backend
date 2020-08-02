databaseChangeLog {
  changeSet(id: '''1596384151062-1''', author: '''emilrasmussen (generated)''') {
    createSequence(incrementBy: 1, sequenceName: '''companies_id_seq''', startValue: 1)
  }

  changeSet(id: '''1596384151062-2''', author: '''emilrasmussen (generated)''') {
    createTable(tableName: '''companies''') {
      column(name: '''id''', type: '''BIGINT''') {
        constraints(primaryKey: true, primaryKeyName: '''companies_pk''')
      }
      column(name: '''company_name''', type: '''VARCHAR(255)''')
      column(name: '''email''', type: '''VARCHAR(255)''')
      column(name: '''phone_number''', type: '''VARCHAR(255)''')
    }
  }

}
