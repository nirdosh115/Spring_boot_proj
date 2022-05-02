package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.expense_entity;

public interface user_service {

	expense_entity update_expense(long exp_id, expense_entity ex);
}
